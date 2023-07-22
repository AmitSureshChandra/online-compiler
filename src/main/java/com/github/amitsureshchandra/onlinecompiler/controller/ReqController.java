package com.github.amitsureshchandra.onlinecompiler.controller;

import com.github.amitsureshchandra.onlinecompiler.dto.CodeReqDto;
import com.github.amitsureshchandra.onlinecompiler.dto.resp.OutputResp;
import com.github.amitsureshchandra.onlinecompiler.service.RunnerService;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequestMapping("/api/v1/run")
public class ReqController {

    final RunnerService runnerService;

    public ReqController(RunnerService runnerService) {
        this.runnerService = runnerService;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping
    OutputResp run(@RequestBody CodeReqDto dto) throws IOException, InterruptedException {
        return runnerService.run(dto);
    }
}
