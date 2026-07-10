package de.trc.create_infinite_lava_block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants{
    public static final String MODID = "create_infinite_lava_block";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public static final VoxelShape LAVA_BLOCK_SHAPE = Shapes.or(
            // bottom
            Block.box(0, 0, 0, 16, 2, 16),

            // ground
            Block.box(0, 14, 0, 16, 16, 16),

            // pillars
            Block.box(0, 0, 0, 2, 16, 2),
            Block.box(14, 0, 0, 16, 16, 2),
            Block.box(0, 0, 14, 2, 16, 16),
            Block.box(14, 0, 14, 16, 16, 16),

            // inner
            Block.box(2, 2, 2, 14, 14, 14)
    );
}
