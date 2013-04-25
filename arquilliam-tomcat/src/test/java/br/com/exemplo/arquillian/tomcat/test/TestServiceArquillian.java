/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.exemplo.arquillian.tomcat.test;


import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.exemplo.arquillian.tomcat.TestServiceImpl;
import br.com.exemplo.arquillian.tomcat.TesteService;
import br.com.exemplo.arquillian.tomcat.util.ClientWs;


@RunWith(Arquillian.class)
public class TestServiceArquillian
{

    @Deployment
    public static WebArchive createTestArchive()
    {
    	
        WebArchive war = ShrinkWrap.create(WebArchive.class, "test2.war")
                                .addClasses( TestServiceImpl.class, TesteService.class)
                                 .addAsLibraries(
                                		 Maven.resolver().loadPomFromFile("pom.xml").importRuntimeDependencies().asFile()
                                		 )
                                		 .addAsResource("applicationContext.xml")
                                .setWebXML("in-container-web.xml");

        return war;
    }
    
    @Test @RunAsClient
    public void test(){
    	ClientWs ws = new ClientWs();
    	ws.chmarServico("https://localhost:8181/test2/rest/testService/findAll");
    }


   
}
