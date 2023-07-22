package com.github.amitsureshchandra.onlinecompiler.service.shell;

import com.github.amitsureshchandra.onlinecompiler.dto.resp.OutputResp;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class ShellService {

    public OutputResp run(String command) throws IOException, InterruptedException {
        // Start the process
        Process process = Runtime.getRuntime().exec(command);

        StringBuilder output = new StringBuilder();
        StringBuilder error = new StringBuilder();

        // Read the output from the process
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        boolean first = true;
        while ((line = reader.readLine()) != null) {
            if(!first) output.append("\n"); else first = false;
            output.append(line);
        }

        first = true;
        // Read the error output from the process
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        while ((line = errorReader.readLine()) != null) {
            if(!first) error.append("\n"); else first = false;
            error.append(line);
        }

        // Wait for the process to complete
        int exitCode = process.waitFor();
        return new OutputResp(output.toString(), error.toString(), exitCode);
    }
}