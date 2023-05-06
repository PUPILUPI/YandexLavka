package de.mokkapps.gamenews.api;

import de.mokkapps.gamenews.api.model.CourierDto;
import de.mokkapps.gamenews.api.model.CreateCourierRequest;
import de.mokkapps.gamenews.api.model.CreateCouriersResponse;
import java.util.Date;
import de.mokkapps.gamenews.api.model.GetCourierMetaInfoResponse;
import de.mokkapps.gamenews.api.model.GetCouriersResponse;
import de.mokkapps.gamenews.api.model.OrderAssignResponse;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:16:00.723357+03:00[Europe/Moscow]")

@Controller
@RequestMapping("${openapi.yandex-lavka.base-path:}")
public class CourierControllerApiController implements CourierControllerApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CourierControllerApiController(NativeWebRequest request) {
        this.request = request;
    }

    /**
     * GET /couriers/assignments : Список распределенных заказов
     *
     * @param date Дата распределения заказов. Если не указана, то используется текущий день (optional)
     * @param courierId Идентификатор курьера для получения списка распредленных заказов. Если не указан, возвращаются данные по всем курьерам. (optional)
     * @return ok (status code 200)
     *         or bad request (status code 400)
     * @see CourierControllerApi#couriersAssignments
     */
    public ResponseEntity<OrderAssignResponse> couriersAssignments(@ApiParam(value = "Дата распределения заказов. Если не указана, то используется текущий день")  @RequestParam(value = "date", required = false) @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE) Optional<Date> date,@ApiParam(value = "Идентификатор курьера для получения списка распредленных заказов. Если не указан, возвращаются данные по всем курьерам.")  @RequestParam(value = "courier_id", required = false) Optional<Integer> courierId) {
        for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"date\" : \"2000-01-23\", \"couriers\" : [ { \"courier_id\" : 0, \"orders\" : [ { \"group_order_id\" : 6, \"orders\" : [ { \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 }, { \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 } ] }, { \"group_order_id\" : 6, \"orders\" : [ { \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 }, { \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 } ] } ] }, { \"courier_id\" : 0, \"orders\" : [ { \"group_order_id\" : 6, \"orders\" : [ { \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 }, { \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 } ] }, { \"group_order_id\" : 6, \"orders\" : [ { \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 }, { \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 } ] } ] } ] }";
                ApiUtil.setExampleResponse(request, "application/json", exampleString);
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /couriers
     *
     * @param createCourierRequest  (required)
     * @return ok (status code 200)
     *         or bad request (status code 400)
     * @see CourierControllerApi#createCourier
     */
    public ResponseEntity<CreateCouriersResponse> createCourier(@ApiParam(value = "" ,required=true )   @RequestBody CreateCourierRequest createCourierRequest) {
        for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"couriers\" : [ { \"regions\" : [ 6, 6 ], \"working_hours\" : [ \"working_hours\", \"working_hours\" ], \"courier_id\" : 0, \"courier_type\" : \"FOOT\" }, { \"regions\" : [ 6, 6 ], \"working_hours\" : [ \"working_hours\", \"working_hours\" ], \"courier_id\" : 0, \"courier_type\" : \"FOOT\" } ] }";
                ApiUtil.setExampleResponse(request, "application/json", exampleString);
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /couriers/{courier_id}
     *
     * @param courierId Courier identifier (required)
     * @return ok (status code 200)
     *         or bad request (status code 400)
     *         or not found (status code 404)
     * @see CourierControllerApi#getCourierById
     */
    public ResponseEntity<CourierDto> getCourierById(@ApiParam(value = "Courier identifier",required=true) @PathVariable("courier_id") Long courierId) {
        for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"regions\" : [ 6, 6 ], \"working_hours\" : [ \"working_hours\", \"working_hours\" ], \"courier_id\" : 0, \"courier_type\" : \"FOOT\" }";
                ApiUtil.setExampleResponse(request, "application/json", exampleString);
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /couriers/meta-info/{courier_id}
     *
     * @param courierId Courier identifier (required)
     * @param startDate Rating calculation start date (required)
     * @param endDate Rating calculation end date (required)
     * @return OK (status code 200)
     * @see CourierControllerApi#getCourierMetaInfo
     */
    public ResponseEntity<GetCourierMetaInfoResponse> getCourierMetaInfo(@ApiParam(value = "Courier identifier",required=true) @PathVariable("courier_id") Long courierId,@ApiParam(value = "Rating calculation start date", required = true)  @RequestParam(value = "startDate", required = true) @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE) Date startDate,@ApiParam(value = "Rating calculation end date", required = true)  @RequestParam(value = "endDate", required = true) @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE) Date endDate) {
        for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"earnings\" : 5, \"regions\" : [ 6, 6 ], \"working_hours\" : [ \"working_hours\", \"working_hours\" ], \"rating\" : 1, \"courier_id\" : 0, \"courier_type\" : \"FOOT\" }";
                ApiUtil.setExampleResponse(request, "application/json", exampleString);
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /couriers
     *
     * @param limit Максимальное количество курьеров в выдаче. Если параметр не передан, то значение по умолчанию равно 1. (optional)
     * @param offset Количество курьеров, которое нужно пропустить для отображения текущей страницы. Если параметр не передан, то значение по умолчанию равно 0. (optional)
     * @return ok (status code 200)
     *         or bad request (status code 400)
     * @see CourierControllerApi#getCouriers
     */
    public ResponseEntity<GetCouriersResponse> getCouriers(@ApiParam(value = "Максимальное количество курьеров в выдаче. Если параметр не передан, то значение по умолчанию равно 1.")  @RequestParam(value = "limit", required = false) Optional<Integer> limit,@ApiParam(value = "Количество курьеров, которое нужно пропустить для отображения текущей страницы. Если параметр не передан, то значение по умолчанию равно 0.")  @RequestParam(value = "offset", required = false) Optional<Integer> offset) {
        for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"couriers\" : [ { \"regions\" : [ 6, 6 ], \"working_hours\" : [ \"working_hours\", \"working_hours\" ], \"courier_id\" : 0, \"courier_type\" : \"FOOT\" }, { \"regions\" : [ 6, 6 ], \"working_hours\" : [ \"working_hours\", \"working_hours\" ], \"courier_id\" : 0, \"courier_type\" : \"FOOT\" } ], \"offset\" : 5, \"limit\" : 1 }";
                ApiUtil.setExampleResponse(request, "application/json", exampleString);
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
