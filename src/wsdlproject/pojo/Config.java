/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsdlproject.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author informatica
 */
@XmlRootElement
public class Config {

    private int port;
            
    private String path;
    
    private String auth;
    
    

    public int getPort() {
            return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getAuth() {
        return auth;
    }

    public String getPath() {
        return path;
    }

    
    public void setPath(String path) {
        this.path = path;
    }

    
    public void setAuth(String auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "Config{" + "path=" + path + ", auth=" + auth + ", port=" + port + '}';
    }
}
