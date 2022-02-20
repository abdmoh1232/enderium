package com.abdmoh.enderium.world.features;

import com.abdmoh.enderium.init.ModBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractSmallTreeFeature;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class EnchantedTreeFeature extends AbstractSmallTreeFeature<TreeFeatureConfig> {

    public EnchantedTreeFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> configIn) {
        super(configIn);
    }

    //places the enchanted tree if the sapling grows
    @Override
    public boolean place(IWorldGenerationReader generationReader, Random rand, BlockPos positionIn, Set<BlockPos> p_225557_4_, Set<BlockPos> p_225557_5_, MutableBoundingBox boundingBoxIn, TreeFeatureConfig configIn) {
        int i = configIn.baseHeight + rand.nextInt(configIn.heightRandA + 1) + rand.nextInt(configIn.heightRandB + 1);
        int j = configIn.trunkHeight >= 0 ? configIn.trunkHeight + rand.nextInt(configIn.trunkHeightRandom + 1) : i - (configIn.foliageHeight + rand.nextInt(configIn.foliageHeightRandom + 1));
        int k = configIn.foliagePlacer.func_225573_a_(rand, j, i, configIn);
        Optional<BlockPos> optional = createCustomOptional(generationReader, i, j, k, positionIn, configIn);
        if (!optional.isPresent()) {
            return false;
        } else {
            BlockPos blockpos = optional.get();
            configIn.foliagePlacer.func_225571_a_(generationReader, rand, configIn, i, j, k, blockpos, p_225557_5_);
            this.func_227213_a_(generationReader, rand, i, blockpos, configIn.trunkTopOffset + rand.nextInt(configIn.trunkTopOffsetRandom + 1), p_225557_4_, boundingBoxIn, configIn);
            return true;
        }
    }

    //custom code below was used in order to change the block the enchanted sapling grows on (to enchanted conjium instead of dirt)
    private Optional<BlockPos> createCustomOptional(IWorldGenerationReader p_227212_1_, int p_227212_2_, int p_227212_3_, int p_227212_4_, BlockPos p_227212_5_, TreeFeatureConfig treeFeatureConfigIn) {
        BlockPos blockpos;
        if (!treeFeatureConfigIn.forcePlacement) {
            int i = p_227212_1_.getHeight(Heightmap.Type.OCEAN_FLOOR, p_227212_5_).getY();
            int j = p_227212_1_.getHeight(Heightmap.Type.WORLD_SURFACE, p_227212_5_).getY();
            blockpos = new BlockPos(p_227212_5_.getX(), i, p_227212_5_.getZ());
            if (j - i > treeFeatureConfigIn.maxWaterDepth) {
                return Optional.empty();
            }
        } else {
            blockpos = p_227212_5_;
        }

        if (blockpos.getY() >= 1 && blockpos.getY() + p_227212_2_ + 1 <= p_227212_1_.getMaxHeight()) {
            for(int i1 = 0; i1 <= p_227212_2_ + 1; ++i1) {
                int j1 = treeFeatureConfigIn.foliagePlacer.func_225570_a_(p_227212_3_, p_227212_2_, p_227212_4_, i1);
                BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

                for(int k = -j1; k <= j1; ++k) {
                    int l = -j1;

                    while(l <= j1) {
                        if (i1 + blockpos.getY() >= 0 && i1 + blockpos.getY() < p_227212_1_.getMaxHeight()) {
                            blockpos$mutable.setPos(k + blockpos.getX(), i1 + blockpos.getY(), l + blockpos.getZ());
                            if (canBeReplacedByLogs(p_227212_1_, blockpos$mutable) && (treeFeatureConfigIn.ignoreVines || !isVine(p_227212_1_, blockpos$mutable))) {
                                ++l;
                                continue;
                            }

                            return Optional.empty();
                        }

                        return Optional.empty();
                    }
                }
            }

            return isConjium(p_227212_1_, blockpos.down()) && blockpos.getY() < p_227212_1_.getMaxHeight() - p_227212_2_ - 1 ? Optional.of(blockpos) : Optional.empty();
        } else {
            return Optional.empty();
        }
    }

    private static boolean isConjium(IWorldGenerationBaseReader generationReader, BlockPos pos) {
        return generationReader.hasBlockState(pos, (p_214582_0_) -> {
            Block block = p_214582_0_.getBlock();
            return block == ModBlocks.ENCHANTED_CONJIUM;
        });
    }
}
