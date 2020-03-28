package com.nutanix.classloader;

import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassLoader extends URLClassLoader {

    private URL[] indir;
    private URLClassLoader parentCl;

    public CustomClassLoader(URL[] indir, URLClassLoader parentCl){
        super(indir);
        this.indir = indir;
        this.parentCl = parentCl;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException{
        //need to implement method with input directory
        URLClassLoader cl = new URLClassLoader(indir);
        Class<?> foundClass = cl.loadClass(name);

        if (foundClass == null){
            foundClass = super.findClass(name);
        }

        return foundClass;
    }

    

    
}