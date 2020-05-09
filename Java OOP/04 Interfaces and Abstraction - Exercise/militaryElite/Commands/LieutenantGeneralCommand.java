package militaryElite.Commands;

import militaryElite.Soldier;
import militaryElite.factories.SoldierFactory;

import java.util.List;

public class LieutenantGeneralCommand extends BaseCommand {


    public LieutenantGeneralCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        super.add(SoldierFactory.produceLieutenantGeneral(args, this.getSoldiers()));
    }
}
