package com.dynamaze.leisure.controllers;


import com.dynamaze.leisure.models.CustomerRequest;
import com.dynamaze.leisure.models.LeisureActivity;
import com.dynamaze.leisure.models.Provider;
import com.dynamaze.leisure.models.requests.CustomerReqRequest;
import com.dynamaze.leisure.models.requests.LeisureActivityRequest;
import com.dynamaze.leisure.models.requests.ProviderRequest;
import com.dynamaze.leisure.models.responses.ApiResponse;
import com.dynamaze.leisure.repositories.CustomerRequestRepository;
import com.dynamaze.leisure.repositories.ProviderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@EnableScheduling
public class ProviderController {

    @Autowired
    ProviderRepository providerRepository;

    @Autowired
    CustomerRequestRepository customerRequestRepository;


    /************
     *
     *  Leisure Activity Provider Endpoints
     *
     */

    @PostMapping(path = "/addProvider", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<Provider> addProvider(@RequestBody ProviderRequest request) {
        return new ApiResponse<>(providerRepository.addProvider(request), "Data Added!");
    }


    @GetMapping(path = "/getProvider", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<Provider> getProvider(@RequestParam int providerId) throws Exception {
        try{
            return new ApiResponse<>(providerRepository.getProvider(providerId), "Success");
        }catch (Exception ex){
            return new ApiResponse<>(null, "Failed. Leisure Activity Provider not found");
        }
    }

    @GetMapping(path = "/getAllProvider", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<List<Provider>> getAllProvider() {
        return new ApiResponse<>(providerRepository.getProviders(), "Success");
    }




    /************
     *
     *  Leisure Activity Endpoints
     *
     */

    @PostMapping(path = "/addLeisureActivity", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<LeisureActivity> addLeisureActivity(@RequestBody LeisureActivityRequest request) throws Exception {
        try{
            return new ApiResponse<>(providerRepository.addLeisureActivity(request), "Data Added!");
        }catch (Exception ex){
            return new ApiResponse<>(null, "Failed. Invalid Leisure Activity Provider Id");
        }
    }


    @GetMapping(path = "/getLeisureActivity", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<LeisureActivity>  addLeisureActivity(@RequestParam int activityId) throws Exception {
        try{
            return new ApiResponse<>(providerRepository.getLeisureActivity(activityId), "Success");
        }catch (Exception ex){
            return new ApiResponse<>(null, "Failed. Leisure Activity not found");
        }
    }


    @GetMapping(path = "/getAllLeisureActivity", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<List<LeisureActivity>> getAllLeisureActivity() {
        return new ApiResponse<>(providerRepository.getAllLeisureActivity(), "Success");
    }

    @Scheduled(cron = "0 0 1 * * SAT")
    @GetMapping(path = "/executeLeisureActivity", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<List<LeisureActivity>> executeLeisureActivity() {
        return new ApiResponse<>(providerRepository.getAllLeisureActivity(), "Success");
    }





    /************
     *
     *  Customer Request Endpoints
     *
     */

    @PostMapping(path = "/addCustomerRequest", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<CustomerRequest> addCustomerRequest(@RequestBody CustomerReqRequest request) throws Exception {
        try{
            return new ApiResponse<>(customerRequestRepository.addCustomerRequest(request), "Data Added!");
        }catch (Exception ex){
            return new ApiResponse<>(null, "Failed. Invalid Leisure Activity Id.");
        }
    }


    @GetMapping(path = "/getCustomerRequest", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<CustomerRequest> addCustomerRequest(@RequestParam int requestId) throws Exception {
        try{
            return new ApiResponse<>(customerRequestRepository.getCustomerRequest(requestId), "Success");
        }catch (Exception ex){
            return new ApiResponse<>(null, "Failed. Customer Request Not found");
        }
    }


    @GetMapping(path = "/getAllCustomerRequest", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<List<CustomerRequest>> getAllCustomerRequest() {
        return new ApiResponse<>(customerRequestRepository.getAllCustomerRequest(), "Success");
    }


}
