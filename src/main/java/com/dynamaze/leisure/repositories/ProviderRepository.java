package com.dynamaze.leisure.repositories;

import com.dynamaze.leisure.models.LeisureActivity;
import com.dynamaze.leisure.models.Provider;
import com.dynamaze.leisure.models.requests.LeisureActivityRequest;
import com.dynamaze.leisure.models.requests.ProviderRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProviderRepository {
    private final Map<Integer, Provider> providers = new HashMap<>();
    private int currentProviderId = 1;
    private int currentActivityId = 1;


    /**
     * Get Provider
     */
    public Provider getProvider(int id) throws Exception {
        if(!providers.containsKey(id))
            throw new Exception("Provider not exists");
        return providers.get(id);
    }


    /**
     * Get Provider Leisure Activity
     */
    public LeisureActivity getLeisureActivity(int activityId) throws Exception {

        final LeisureActivity[] activity = new LeisureActivity[1];
        providers.forEach((integer, provider) -> {
            if(provider.getLeisureActivities().containsKey(activityId))
                activity[0] = provider.getLeisureActivities().get(activityId);
        });

        if(activity[0] == null)
            throw new Exception("Leisure Activity not exists");

        return activity[0];
    }



    /**
     * Add a new provider
     */
    public Provider addProvider(ProviderRequest request){
        var provider = new Provider();
        provider.setId(currentProviderId);
        provider.setName(request.getName());
        provider.setAddress(request.getAddress());
        providers.put(currentProviderId++, provider);
        return provider;
    }


    /**
     * Add a new leisure activity under the provider
     */
    public LeisureActivity addLeisureActivity(LeisureActivityRequest request) throws Exception{
        // Get Provider
        var provider = getProvider(request.getProvideId());

        // Init Lecture
        var leisureActivity = new LeisureActivity();
        leisureActivity.setId(currentActivityId++);
        leisureActivity.setDescription(request.getDescription());
        leisureActivity.setHeadline(request.getHeadline());
        leisureActivity.setHints(request.getHints());
        leisureActivity.setDate(request.getDate());
        leisureActivity.setProvideId(request.getProvideId());
        leisureActivity.setProviderName(provider.getName());
        leisureActivity.setProviderAddress(provider.getAddress());
        leisureActivity.setProviderWebsite("http://localhost:8080/getProvider?providerId=" + request.getProvideId());

        // Add Activity
        provider.addLeisureActivity(leisureActivity);
        return leisureActivity;
    }


    /**
     * Get all providers and leisure activities
     */
    public List<Provider> getProviders() {
        List<Provider> providerList = new ArrayList<>();
        providers.forEach((integer, provider) -> providerList.add(provider));
        return providerList;
    }

    /**
     * Get all leisure
     */
    public List<LeisureActivity> getAllLeisureActivity() {
        List<LeisureActivity> leisureActivities = new ArrayList<>();
        providers.forEach((integer, provider) ->
                provider.getLeisureActivities().forEach((integer1, leisureActivity) ->  leisureActivities.add(leisureActivity)));
        return leisureActivities;
    }
}
