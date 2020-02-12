/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsdlproject.parser;

import wsdlproject.pojo.App;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author informatica
 */
public class wsdlProjectParser {

    public App parse(String filename) throws URISyntaxException, JAXBException {

        URL resource = getClass().getClassLoader().getResource(filename);
        
        File file = new File(resource.toURI());

        JAXBContext jaxbContext = JAXBContext.newInstance(App.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        App app = (App) jaxbUnmarshaller.unmarshal(file);
        return app;
    }

}
