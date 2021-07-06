package com.dynamaze.leisure.repositories;

import com.dynamaze.leisure.models.CustomerRequest;
import com.dynamaze.leisure.models.requests.CustomerReqRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRequestRepository {
    private final Map<Integer, CustomerRequest> customerRequests = new HashMap<>();
    private int currentCustomerRequestId = 1;


    @Autowired
    ProviderRepository providerRepository;



    /**
     * Add a new customer request
     */
    public CustomerRequest addCustomerRequest(CustomerReqRequest request) throws Exception {
        var activity = providerRepository.getLeisureActivity(request.getLeisureActivityId());

        var customerRequest = new CustomerRequest();
        customerRequest.setId(currentCustomerRequestId);
        customerRequest.setLeisureActivityId(activity.getId());
        customerRequest.setLeisureActivity(activity);
        customerRequest.setRequestedDate(request.getRequestedDate());

        customerRequests.put(currentCustomerRequestId++, customerRequest);
        return customerRequest;
    }



    /**
     * Get Customer Request
     */
    public CustomerRequest getCustomerRequest(int customerRequestId) throws Exception {

        if(!customerRequests.containsKey(customerRequestId))
            throw new Exception("Customer request not found");

        return customerRequests.get(customerRequestId);
    }


    /**
     * Get All Customer Request
     */
    public List<CustomerRequest> getAllCustomerRequest() {
        List<CustomerRequest> customerRequestList = new ArrayList<>();
        customerRequests.forEach((integer, request) -> customerRequestList.add(request));
        return customerRequestList;
    }


}
