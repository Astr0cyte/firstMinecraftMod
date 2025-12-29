**Eager Initialisation**: When objects are created upfront, altogether, all at once.

**Lazy Initialisation**: When objects are created only when they are accessed ("needed").

- DeferredRegister is an applied example of Lazy Initialisation.
- Minecraft in general uses a Lazy Initialisation approach to creating objects.



    - One small nuance added (courtesy of Gemini AI agent): Vanilla Minecraft (the base game code written by Mojang) historically used a lot of Eager initialization. 
    - This is partly why the game takes a while to launch!
    - Modded Minecraft (what you are doing) has moved almost entirely to Lazy initialization (via DeferredRegister). 
    - This is crucial because when you have 200 mods installed, if everyone used Eager initialization, the game would run out of RAM before it even reached the title screen.
