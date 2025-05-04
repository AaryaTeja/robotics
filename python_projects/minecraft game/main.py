# main.py

import pygame
from player import Player
from world import World
from game_functions import *

def main():
    pygame.init()

    screen_width, screen_height = 800, 600
    screen = pygame.display.set_mode((screen_width, screen_height))
    pygame.display.set_caption("Minecraft Lite")

    clock = pygame.time.Clock()

    player = Player(100, 100)  # Initial player position
    world = World()

    while True:
        screen.fill((135, 206, 250))  # Sky blue background

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                return

        handle_keys(player)

        world.draw(screen)
        player.draw(screen)

        pygame.display.flip()
        clock.tick(60)

if __name__ == "__main__":
    main()
