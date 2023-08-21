package br.com.controller;

import br.com.domain.TranslateRequest;
import br.com.service.TranslateService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TranslateController {

    @Inject
    TranslateService translateService;

    @POST
    @Path("/translate")
    public String converterTraducao(@RequestBody TranslateRequest translateRequest){
        return translateService.traslateRequest(translateRequest);
    }
}
