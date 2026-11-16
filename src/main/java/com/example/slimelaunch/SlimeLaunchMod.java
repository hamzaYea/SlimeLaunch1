package com.example.slimelaunch;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class SlimeLaunchMod implements ModInitializer {
    // Increase this value for a stronger launch.
    private static final double LAUNCH_STRENGTH = 1.5;

    @Override
    public void onInitialize() {
        UseItemCallback.EVENT.register((Player player, Level level, net.minecraft.world.InteractionHand hand) -> {
            var stack = player.getItemInHand(hand);

            // Negative X rotation means the player is looking upward.
            if (!player.isSpectator()
                    && stack.is(Items.SLIME_BALL)
                    && player.getXRot() < 0.0F) {

                // Apply the launch on the logical server only.
                if (!level.isClientSide()) {
                    player.setDeltaMovement(player.getLookAngle().scale(LAUNCH_STRENGTH));
                    player.hurtMarked = true;
                    stack.shrink(1);
                }

                return InteractionResult.SUCCESS;
            }

            return InteractionResult.PASS;
        });
    }
}
