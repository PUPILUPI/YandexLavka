package org.openapitools.api;

import org.openapitools.model.CourierDto;
import org.openapitools.model.CreateCourierRequest;
import org.openapitools.model.CreateCouriersResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.model.GetCourierMetaInfoResponse;
import org.openapitools.model.GetCouriersResponse;
import java.time.LocalDate;
import org.openapitools.model.OrderAssignResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:41:42.473217200+03:00[Europe/Moscow]")
@Controller
@RequestMapping("${openapi.yandexLavka.base-path:}")
public class CouriersApiController implements CouriersApi {

    private final NativeWebRequest request;

    @Autowired
    public CouriersApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
