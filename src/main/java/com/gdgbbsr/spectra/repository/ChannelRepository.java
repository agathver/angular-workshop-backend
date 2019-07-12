package com.gdgbbsr.spectra.repository;

import com.gdgbbsr.spectra.models.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "channels", path = "channels")
public interface ChannelRepository extends JpaRepository<Channel, UUID> {
}
