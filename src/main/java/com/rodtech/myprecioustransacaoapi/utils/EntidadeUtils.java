package com.rodtech.myprecioustransacaoapi.utils;

import org.apache.commons.beanutils.BeanUtils;

public class EntidadeUtils {

    public static void copiarPropriedades(Object destino, Object origem){
        try{
            BeanUtils.copyProperties(destino, origem);
        } catch (Exception ex){
            throw new RuntimeException("Erro ao copiar recurso");
        }
    }
}
