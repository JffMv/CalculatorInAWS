package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller class for handling calculator operations and interactions with the view.
 */
@Controller
public class CalculatorController {

    /**
     * Handles GET requests for the calculator form.
     *
     * @param model the model to add attributes to
     * @return the name of the view to be rendered
     */
    @GetMapping("/calculator")
    public String showForm(Model model) {
        model.addAttribute("calculator", new Calculator());
        return "calculator";
    }

    /**
     * Handles POST requests for performing calculations.
     *
     * @param calculator the calculator object containing the current operation and number
     * @param model the model to add attributes to
     * @return the name of the view to be rendered
     */
    @PostMapping("/calculator")
    public String calculate(@ModelAttribute Calculator calculator, Model model) {
        double result = calculator.calculate();
        calculator.addHistoryEntry(result);
        model.addAttribute("calculator", calculator);
        return "calculator";
    }
}
