class Solution {
    public boolean isRobotBounded(String instructions) {
        int horizMovement = 0;
        int vertMovement = 0;
        String direction = "N";
        for (int i = 0; i < instructions.length(); i++) {
            String instruction = instructions.charAt(i) + "";
            if (instruction.equals("G")) {
                if ("N".equals(direction)) {
                    horizMovement++;
                } else if ("E".equals(direction)) {
                    vertMovement++;
                } else if ("S".equals(direction)) {
                    horizMovement--;
                } else if ("W".equals(direction)) {
                    vertMovement--;
                }
            } else if (instruction.equals("R")) {
                if ("N".equals(direction)) {
                    direction = "E";
                } else if ("E".equals(direction)) {
                    direction = "S";
                } else if ("S".equals(direction)) {
                    direction = "W";
                } else if ("W".equals(direction)) {
                    direction = "N";
                }
            } else if (instruction.equals("L")) {
                if ("N".equals(direction)) {
                    direction = "W";
                } else if ("E".equals(direction)) {
                    direction = "N";
                } else if ("S".equals(direction)) {
                    direction = "E";
                } else if ("W".equals(direction)) {
                    direction = "S";
                }
            }
        }
        
        if ((horizMovement == 0 && vertMovement == 0) || !direction.equals("N")) {
            return true;
        }
        return false;
    }
}