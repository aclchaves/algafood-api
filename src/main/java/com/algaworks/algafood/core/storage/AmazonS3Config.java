package com.algaworks.algafood.core.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public  class AmazonS3Config {
	
	@Autowired
	private StorageProperties sotraProperties;
	
	@Bean
	public AmazonS3 amazonS3() {
		var credentials = new BasicAWSCredentials(
				sotraProperties.getS3().getIdChaveAcesso(),
				sotraProperties.getS3().getChaveAcessoSecreta());
		
		return AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(sotraProperties.getS3().getRegiao())
				.build();
	}

}
