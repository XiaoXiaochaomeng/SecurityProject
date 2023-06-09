package com.jwt.JWT.Project.service.Impl;

import com.jwt.JWT.Project.config.StorageProperties;
import com.jwt.JWT.Project.exception.StorageException;
import com.jwt.JWT.Project.exception.StorageFileNotFoundException;
import com.jwt.JWT.Project.service.StorageService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageServiceImpl implements StorageService {
	private final Path rootLocation;

	@Override
	public String getStoredFilename(MultipartFile file, String id) {// tao file luu tru
		String ext = file.getOriginalFilename();
		return ext;
	}

	public FileSystemStorageServiceImpl(StorageProperties properties) {// truyen thong tin cau hinh luu tru
		this.rootLocation = Paths.get(properties.getLocation());
	}

	@Override
	public void store(MultipartFile file, String storedFilename) {// luu noi dung file
		try {
			if (file.isEmpty()) {
				throw new StorageException("Failed to store empty file");
			}

			Path destinationFile = this.rootLocation.resolve(Paths.get(storedFilename)).normalize().toAbsolutePath();
			if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
				throw new StorageException("Cannot store file outside current directory");
			}
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (Exception e) {
			throw new StorageException("Failed to store file", e);
		}
	}

	@Override
	public Resource loadAsResource(String filename) {// nap noi dung file
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}

			throw new StorageFileNotFoundException("Could not read file: " + filename);
		} catch (Exception e) {
			throw new StorageFileNotFoundException("Could not read file: " + filename);
		}
	}

	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}

	@Override
	public void delete(String storedFilename) throws IOException {
		Path destinationFile = rootLocation.resolve(Paths.get(storedFilename)).normalize().toAbsolutePath();
		Files.delete(destinationFile);
	}
}
