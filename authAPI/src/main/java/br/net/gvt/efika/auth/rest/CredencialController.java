/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.auth.rest;

import br.net.gvt.efika.auth.rest.request.VerificarCredencialRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.net.gvt.efika.auth.model.service.factory.FactoryService;

/**
 *
 * @author G0042204
 */
@Path("/credencial")
public class CredencialController extends RestJaxAbstract {
    
    @POST
    @Path("/verificar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response verificar(VerificarCredencialRequest body) {
        Boolean verificar = null;
        body.setLogin(body.getLogin().toUpperCase());
        try {
            verificar = FactoryService.newCredencialService().verificar(body);
            return ok(verificar);
        } catch (Exception e) {
            return serverError(new Exception("Falha ao consultar Serviço de Autenticação!"));
        }
    }
    
}
