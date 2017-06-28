package Controller;

import DAO.ItemListDao;
import Model.Item;
import Util.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.math.BigDecimal;

@Controller
public class VendingController {
    ItemListDao dao;


    @Inject
    public VendingController(ItemListDao dao) {
        this.dao = dao;
        Utils.deploy(this.dao);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String vending(Model model) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (Item item : dao.getAllItems()) {
            if (i % 3 == 0)
                sb.append("<div class='row'>");
            sb.append("<div class=\"col-lg-3 col-lg-offset-1 good-container\" onclick=\"addElement(" + item.getId() + ", " + item.getPrice() +");\">");
            sb.append("<div>" + item.getId() + "</div><h4 class=\"header\">" + item.getName() + "</h4><h4 class=\"header\">$" + item.getPrice() + "</h4><h5 class=\"header\">Quantity Left: " + item.getQuantity() + "</h5>");
            sb.append("</div>");
            if (i % 3 == 2) {
                sb.append("</div>");
                sb.append("<br>");
            }
            i++;
        }
        if (i % 3 != 0)
            sb.append("</div>");
        model.addAttribute("items", sb.toString());
        return "home";
    }

    @RequestMapping(value = "/money", method = RequestMethod.POST)
    String loadGoods(@RequestParam("total") float total, @RequestParam("item") Integer item_id, Model model) {

        if (item_id == null)
            return "redirect:/";

        model.addAttribute("item_id", item_id);

        Item item = dao.getItemById(item_id);

        if (item.getQuantity() == 0) {
            model.addAttribute("message", "SOLD OUT!");
            model.addAttribute("total", total);
            return "redirect:/";
        }

        if (item.getPrice() > total) {
            model.addAttribute("message", "NOT ENOUGH MONEY");
            model.addAttribute("total", total);
            return "redirect:/";
        }
        item.setQuantity(item.getQuantity() - 1);


        model.addAttribute("message", "Thank you!");
        model.addAttribute("total", new BigDecimal(total-item.getPrice()).setScale(2, BigDecimal.ROUND_HALF_UP) );
        return "redirect:/";
    }
}
