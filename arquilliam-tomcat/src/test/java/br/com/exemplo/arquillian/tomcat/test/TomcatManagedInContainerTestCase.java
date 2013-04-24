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

import java.util.logging.Logger;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.exemplo.arquillian.tomcat.MyBean;
import br.com.exemplo.arquillian.tomcat.MyServlet;

/**
 * Tests that Tomcat deployments into the Tomcat server work through the
 * Arquillian lifecycle
 *
 * @author Dan Allen
 * @version $Revision: $
 */
@RunWith(Arquillian.class)
public class TomcatManagedInContainerTestCase
{
    private static final Logger log = Logger.getLogger(TomcatManagedInContainerTestCase.class.getName());

    /**
     * Define the deployment
     */
    @Deployment
    public static WebArchive createTestArchive()
    {
        WebArchive war = ShrinkWrap.create(WebArchive.class, "test2.war")
                                .addClasses(MyServlet.class, MyBean.class)
                                /*   .addAsLibraries(
                                         DependencyResolvers.use(MavenDependencyResolver.class)
                                               .loadMetadataFromPom("pom.xml")
                                               .goOffline()
                                               .artifact("org.jboss.weld.servlet:weld-servlet")
                                               .resolveAs(GenericArchive.class))

                                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")*/
                                .setWebXML("in-container-web.xml");
        /// DEBUG - see what's
        //war.as(ZipExporter.class).exportTo( new File("/tmp/arq.zip"), true );
        return war;
    }
    
    @Test @RunAsClient
    public void test(){
    	System.out.println("");
    }


   
}
