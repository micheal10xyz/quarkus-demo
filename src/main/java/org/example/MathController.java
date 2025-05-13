package org.example;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/v1")
public class MathController {

    @POST
    @Path("/multiply")
    @Operation(summary = "计算整数乘积接口")
    @APIResponse(responseCode = "200",
            content = @Content(mediaType = MediaType.TEXT_PLAIN,
                schema = @Schema(implementation = Integer.class)
            )
    )
    public Response multiply(@FormParam("a") Integer a, @FormParam("b") Integer b) {
        if (a == null || b == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(a * b).build();
        }
    }

    @POST
    @Path("/add")
    @Operation(summary = "计算整数之和接口")
    @APIResponse(responseCode = "200",
            content = @Content(mediaType = MediaType.TEXT_PLAIN,
                    schema = @Schema(implementation = Integer.class)
            )
    )
    public Response add(@FormParam("a") Integer a, @FormParam("b") Integer b) {
        if (a == null || b == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.ok(a + b).build();
        }
    }

}
