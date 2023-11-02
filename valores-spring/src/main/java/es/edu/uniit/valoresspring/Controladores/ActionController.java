package es.edu.uniit.valoresspring.Controladores;

import es.edu.uniit.valoresspring.Modelo.Action;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Hecho por Jesus Gabriel Parra Dugarte

@RestController
@RequestMapping("/actions")
public class ActionController
{
    ArrayList<Action> actions = new ArrayList<Action>
            (
                    List.of(
                            new Action("a", 100d,90d,120d,80d),
                            new Action("b", 110d,100d,130d,90d),
                            new Action("c", 120d,110d,140d,100d)
                    )
            );

    @GetMapping
    public  ArrayList<Action> ShowActions()
    {
        return actions;
    }

    @GetMapping("/{name}")
    public Action searchByName(@PathVariable String name)
    {
        for(Action action : actions)
        {
            if(action.getName().equalsIgnoreCase(name))
            {
                 return action;
            }
        }
        return null;
    }

    @PostMapping
    public void createAction(@RequestBody Action action)
    {
        actions.add(action);
    }

    @PutMapping("/{name}")
    public void updateAction(@RequestBody Action actionToUpdate)
    {
        for(Action action : actions)
        {
            if(action.getName().equalsIgnoreCase(actionToUpdate.getName()))
            {
                action.setPreviousPrice(action.getCurrentPrice());
                action.setCurrentPrice(actionToUpdate.getCurrentPrice());
                action.setUpperThreshold(actionToUpdate.getUpperThreshold());
                action.setLowerThreshold(actionToUpdate.getLowerThreshold());
            }
        }
    }

    @DeleteMapping("/{name}")
    public void deleteAction(@PathVariable String name)
    {
        Optional<Action> optionalAction = actions.stream().filter(action -> action.getName().equalsIgnoreCase(name)).findFirst();

        if(optionalAction.isPresent())
        {
            actions.remove(optionalAction.get());
        }
    }
}
