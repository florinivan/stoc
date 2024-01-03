package it.phime.stoc.controller;

import it.phime.stoc.service.CsvParser;
import it.phime.stoc.service.StocService;
import it.phime.stoc.service.StocUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Controller
@RequestMapping("/stoc")
public class StocController {

    private final StocService stocService;

    @Autowired
    public StocController(StocService stocService) {
        this.stocService = stocService;
    }

    @PostMapping("/updateFromCsv")
    public String updateFromCsv(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "redirect:/stoc/error"; // Handle empty file error
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            List<StocUpdateRequest> stocUpdateRequests = CsvParser.parseCsv(reader);
            stocService.updateStocValues(stocUpdateRequests);
        } catch (IOException e) {
            e.printStackTrace(); // Handle IO exception
            return "redirect:/stoc/error";
        }

        return "redirect:/stoc/success";
    }
}
