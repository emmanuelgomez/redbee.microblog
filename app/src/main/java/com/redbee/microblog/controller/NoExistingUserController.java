package com.redbee.microblog.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="NoExistingUserControllerValue", description="User mentions to users that not posted are considerer No Existing Users")
public class NoExistingUserController {
}
