package com.litanocg.digitalcourse.entities.mappers;

import com.litanocg.digitalcourse.entities.Coupon;
import com.litanocg.digitalcourse.entities.dtos.CouponDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CouponMapper {

    CouponMapper INSTANCE = Mappers.getMapper(CouponMapper.class);

    CouponDTO toDTO(Coupon coupon);

    @Mapping(target = "couponID", ignore = true) // Evita sobrescribir el ID
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "statusUpdatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "statusRegistry", ignore = true) // Se asigna en la lógica de negocio
    Coupon toEntity(CouponDTO couponDTO);

    @Mapping(target = "createdAt", ignore = true) // No modificar createdAt en actualización
    void updateCouponFromDTO(CouponDTO couponDTO, @MappingTarget Coupon coupon);
}
