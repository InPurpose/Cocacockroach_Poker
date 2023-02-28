public enum CardType {
    BAT,FLY,COCKROACH,TOAD,RAT,SCORPION,SPIDER,STINKBUG,BACK;

    public static CardType getRandomCardType()
    {
        int temp = (int)((Math.random()) *8);

        switch (temp)
        {
            case 0: return BAT;
            case 1: return FLY;
            case 2: return COCKROACH;
            case 3: return TOAD;
            case 4: return RAT;
            case 5: return SCORPION;
            case 6: return SPIDER;
            case 7: return STINKBUG;
            default: return BACK;

        }
    }

    public static String getColorFilePath(CardType type)
    {
        switch (type)
        {
            case BAT: return "CockRoach Poker Sprites/Bat.jpg";
            case FLY: return "CockRoach Poker Sprites/Fly.jpg";
            case COCKROACH: return "CockRoach Poker Sprites/CockRoach.jpg";
            case TOAD: return "CockRoach Poker Sprites/Toad.jpg";
            case RAT: return "CockRoach Poker Sprites/Rat.jpg";
            case SCORPION: return "CockRoach Poker Sprites/Scorpion.jpg";
            case SPIDER: return "CockRoach Poker Sprites/Spider.jpg";
            case STINKBUG: return "CockRoach Poker Sprites/StinkBug.jpg";

            default: return "CockRoach Poker Sprites/back.jpg";
        }
    }

    public static String getGrayFilePath(CardType type)
    {
        switch (type)
        {
            case BAT: return "CockRoach Poker Sprites/Bat_Gray.jpg";
            case FLY: return "CockRoach Poker Sprites/Fly_Gray.jpg";
            case COCKROACH: return "CockRoach Poker Sprites/CockRoach_Gray.jpg";
            case TOAD: return "CockRoach Poker Sprites/Toad_Gray.jpg";
            case RAT: return "CockRoach Poker Sprites/Rat_Gray.jpg";
            case SCORPION: return "CockRoach Poker Sprites/Scorpion_Gray.jpg";
            case SPIDER: return "CockRoach Poker Sprites/Spider_Gray.jpg";
            case STINKBUG: return "CockRoach Poker Sprites/StinkBug_Gray.jpg";

            default: return "CockRoach Poker Sprites/back.jpg";
        }
    }

    public static CardType IndexToType(int num)
    {
        switch (num)
        {
            case 0: return BAT;
            case 1: return FLY;
            case 2: return COCKROACH;
            case 3: return TOAD;
            case 4: return RAT;
            case 5: return SCORPION;
            case 6: return SPIDER;
            case 7: return STINKBUG;
            default: return BACK;
        }
    }



    public static int TypeToIndex(CardType cardType)
    {
        switch (cardType)
        {
            case BAT: return 0;
            case FLY: return 1;
            case COCKROACH: return 2;
            case TOAD: return 3;
            case RAT: return 4;
            case SCORPION: return 5;
            case SPIDER: return 6;
            case STINKBUG: return 7;

            default: return -1;
        }
    }


}
