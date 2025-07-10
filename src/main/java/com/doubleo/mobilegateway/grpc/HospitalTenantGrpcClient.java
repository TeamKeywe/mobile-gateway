package com.doubleo.mobilegateway.grpc;

import com.doubleo.tenantservice.domain.tenant.grpc.HospitalIdToTenantIdRequest;
import com.doubleo.tenantservice.domain.tenant.grpc.HospitalIdToTenantIdResponse;
import com.doubleo.tenantservice.domain.tenant.grpc.HospitalTenantServiceGrpc;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class HospitalTenantGrpcClient {

    @GrpcClient("tenant-service")
    private HospitalTenantServiceGrpc.HospitalTenantServiceBlockingStub tenantStub;

    public String getTenantIdByHospitalId(Long hospitalId) {

        try {
            HospitalIdToTenantIdRequest request =
                    HospitalIdToTenantIdRequest.newBuilder().setHospitalId(hospitalId).build();
            HospitalIdToTenantIdResponse response = tenantStub.getTenantIdByHospitalId(request);
            return response.getTenantId();
        } catch (Exception e) {
            throw new StatusRuntimeException(
                    Status.INTERNAL.withDescription(e.getMessage()).withCause(e));
        }
    }
}
