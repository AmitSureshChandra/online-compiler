package com.github.amitsureshchandra.onlinecompiler.service;

import com.github.amitsureshchandra.onlinecompiler.dto.CodeReqDto;
import com.github.amitsureshchandra.onlinecompiler.dto.resp.OutputResp;
import com.github.amitsureshchandra.onlinecompiler.service.java.Jdk8Service;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RunnerService {

    final Jdk8Service jdk8Service;

    public RunnerService(Jdk8Service jdk8Service) {
        this.jdk8Service = jdk8Service;
    }

    public OutputResp run(CodeReqDto dto) throws IOException, InterruptedException {
        switch (dto.getCompiler()) {
            case "jdk8":
                return jdk8Service.run(dto);
        }
        return new OutputResp(null, "compiler not found", -1);
    }
}
