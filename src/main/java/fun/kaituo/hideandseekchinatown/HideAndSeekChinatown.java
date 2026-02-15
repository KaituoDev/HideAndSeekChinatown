package fun.kaituo.hideandseekchinatown;

import fun.kaituo.gameutils.GameUtils;
import fun.kaituo.hideandseek.HideAndSeekGame;
import fun.kaituo.hideandseek.state.IdleState;
import fun.kaituo.hideandseek.state.RunningState;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import java.util.List;

public final class HideAndSeekChinatown extends HideAndSeekGame {

    private IdleState idleState;
    private RunningState runningState;

    @Override
    public IdleState getIdleState() {
        return idleState;
    }

    @Override
    public RunningState getRunningState() {
        return runningState;
    }

    @Override
    public List<Material> getDisguiseMaterials() {
        return List.of(
                Material.POLISHED_ANDESITE,
                Material.BOOKSHELF,
                Material.OAK_LEAVES,
                Material.SPRUCE_PLANKS,
                Material.WHITE_WOOL
        );
    }

    @Override
    protected void initLocations() {
        World world = GameUtils.inst().getMainWorld();
        saveLoc("mapSpawn", new Location(world, -2985.5, 87.0, -32.5));
        saveLoc("waitingRoom", new Location(world, -2999.5, 100.0, 0.5));
        saveLoc("gameTimeSign", new Location(world, -2941, 87, -33));
        saveLoc("hub", new Location(world, -2938, 87, -33));
        saveLoc("startButton", new Location(world, -2941, 88, -33));
    }

    @Override
    protected void initGameStates() {
        idleState = new IdleState();
        runningState = new RunningState();
        idleState.init(this);
        runningState.init(this);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        updateExtraInfo("§c方块捉迷藏-唐人街", getLoc("hub"));
    }
}
