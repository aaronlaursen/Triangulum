package edu.macalester.modules.find;

import edu.macalester.modules.locationFetcher.locationFetcher;
import edu.macalester.modules.triangulumModule;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: aaron
 * Date: 11/29/12
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class find extends triangulumModule {

    public String getTxt(){
        String out="";
        try{
            locationFetcher locFetch= new locationFetcher();
            locFetch.setContext(context);
            String loc=locFetch.getTxt();
            URL whereurl = new URL("http://maps.google.com/maps/api/geocode/json?latlng="+loc+"&sensor=true");
            BufferedReader in = new BufferedReader(new InputStreamReader(whereurl.openStream()));
            String line = in.readLine();

            while (line != null){
                if (line.contains("formatted_address")){
                    out=line.split(":")[1];
                    break;
                }
            }
        } catch (Exception e){
            out="error occured:(";
        }
        return out;
    }
}
