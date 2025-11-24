package org.example.fegin;

import org.springframework.cloud.openfeign.FeignClient;

/**
 *
 *
 * @author LXZ 2025/11/24 17:31
 */
@FeignClient(value = "merchandise-api" , contextId = "MerchandiseApiFeign", path = "/merchandise/")
public interface MerchandiseFeign {

}
