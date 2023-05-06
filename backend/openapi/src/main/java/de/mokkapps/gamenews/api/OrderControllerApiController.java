package de.mokkapps.gamenews.api;

import de.mokkapps.gamenews.api.model.CompleteOrderRequestDto;
import de.mokkapps.gamenews.api.model.CreateOrderRequest;
import java.util.Date;
import de.mokkapps.gamenews.api.model.OrderAssignResponse;
import de.mokkapps.gamenews.api.model.OrderDto;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-06T14:27:20.658336400+03:00[Europe/Moscow]")

@Controller
@RequestMapping("${openapi.yandex-lavka.base-path:}")
public class OrderControllerApiController implements OrderControllerApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OrderControllerApiController(NativeWebRequest request) {
        this.request = request;
    }

    /**
     * POST /orders/complete
     *
     * @param completeOrderRequestDto  (required)
     * @return ok (status code 200)
     *         or bad request (status code 400)
     * @see OrderControllerApi#completeOrder
     */
    public ResponseEntity<List<OrderDto>> completeOrder(@ApiParam(value = "" ,required=true )   @RequestBody CompleteOrderRequestDto completeOrderRequestDto) {
        for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 }";
                ApiUtil.setExampleResponse(request, "application/json", exampleString);
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /orders
     *
     * @param createOrderRequest  (required)
     * @return ok (status code 200)
     *         or bad request (status code 400)
     * @see OrderControllerApi#createOrder
     */
    public ResponseEntity<List<OrderDto>> createOrder(@ApiParam(value = "" ,required=true )   @RequestBody CreateOrderRequest createOrderRequest) {
        for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 }";
                ApiUtil.setExampleResponse(request, "application/json", exampleString);
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /orders/{order_id}
     *
     * @param orderId Order identifier (required)
     * @return ok (status code 200)
     *         or bad request (status code 400)
     *         or not found (status code 404)
     * @see OrderControllerApi#getOrder
     */
    public ResponseEntity<OrderDto> getOrder(@ApiParam(value = "Order identifier",required=true) @PathVariable("order_id") Long orderId) {
        for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 }";
                ApiUtil.setExampleResponse(request, "application/json", exampleString);
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /orders
     *
     * @param limit Максимальное количество заказов в выдаче. Если параметр не передан, то значение по умолчанию равно 1. (optional)
     * @param offset Количество заказов, которое нужно пропустить для отображения текущей страницы. Если параметр не передан, то значение по умолчанию равно 0. (optional)
     * @return ok (status code 200)
     *         or bad request (status code 400)
     * @see OrderControllerApi#getOrders
     */
    public ResponseEntity<List<OrderDto>> getOrders(@ApiParam(value = "Максимальное количество заказов в выдаче. Если параметр не передан, то значение по умолчанию равно 1.")  @RequestParam(value = "limit", required = false) Optional<Integer> limit,@ApiParam(value = "Количество заказов, которое нужно пропустить для отображения текущей страницы. Если параметр не передан, то значение по умолчанию равно 0.")  @RequestParam(value = "offset", required = false) Optional<Integer> offset) {
        for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 }";
                ApiUtil.setExampleResponse(request, "application/json", exampleString);
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /orders/assign : Распределение заказов по курьерам
     * Для распределения заказов между курьерами учитываются следующие параметры: &lt;ul&gt;&lt;li&gt;вес заказа&lt;/li&gt;&lt;li&gt;регион доставки&lt;/li&gt;&lt;li&gt;стоимость доставки&lt;/li&gt;&lt;/ul&gt;
     *
     * @param date Дата распределения заказов. Если не указана, то используется текущий день (optional)
     * @return ok (status code 201)
     *         or bad request (status code 400)
     * @see OrderControllerApi#ordersAssign
     */
    public ResponseEntity<List<OrderAssignResponse>> ordersAssign(@ApiParam(value = "Дата распределения заказов. Если не указана, то используется текущий день")  @RequestParam(value = "date", required = false) @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE) Optional<Date> date) {
        for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"date\" : \"2000-01-23\", \"couriers\" : [ { \"courier_id\" : 0, \"orders\" : [ { \"group_order_id\" : 6, \"orders\" : [ { \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 }, { \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 } ] }, { \"group_order_id\" : 6, \"orders\" : [ { \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 }, { \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 } ] } ] }, { \"courier_id\" : 0, \"orders\" : [ { \"group_order_id\" : 6, \"orders\" : [ { \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 }, { \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 } ] }, { \"group_order_id\" : 6, \"orders\" : [ { \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 }, { \"regions\" : 1, \"cost\" : 5, \"completed_time\" : \"2000-01-23T04:56:07.000+00:00\", \"weight\" : 6.0274563, \"delivery_hours\" : [ \"delivery_hours\", \"delivery_hours\" ], \"order_id\" : 0 } ] } ] } ] }";
                ApiUtil.setExampleResponse(request, "application/json", exampleString);
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
