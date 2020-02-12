/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsdlproject.pojo;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author informatica
 */
@XmlRootElement
public class App {
    private List<Config> config;

    public List<Config> getConfig() {
        return config;
    }

    public void setConfig(List<Config> config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return "App{" + "config=" + config + '}';
    }

    
    
}
