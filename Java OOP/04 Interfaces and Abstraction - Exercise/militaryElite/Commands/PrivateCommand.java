package militaryElite.Commands;

import militaryElite.Soldier;
import militaryElite.factories.SoldierFactory;

import java.util.Collection;
import java.util.List;

public class PrivateCommand extends BaseCommand{


    public PrivateCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        super.add(SoldierFactory.producePrivate(args));
    }
}
