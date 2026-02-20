package com.microservices.pay.model.mapper;

import com.microservices.pay.model.dto.PaymentDTO;
import com.microservices.pay.model.entity.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentDTO PaymentToDTO(Payment payment);
    Payment PaymentDTOToEntity(PaymentDTO paymentDTO);
    List<PaymentDTO> paymentListToDTOList(List<Payment> payments);
}
