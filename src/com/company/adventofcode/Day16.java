package com.company.adventofcode;

import java.util.ArrayList;

public class Day16 {

    ArrayList<Integer> versions = new ArrayList<>();

    public static void main(String[] args) {
        String input = "A20D5080210CE4BB9BAFB001BD14A4574C014C004AE46A9B2E27297EECF0C013F00564776D7E3A825CAB8CD47B6C537DB99CD746674C1000D29BBC5AC80442966FB004C401F8771B61D8803D0B22E4682010EE7E59ACE5BC086003E3270AE4024E15C8010073B2FAD98E004333F9957BCB602E7024C01197AD452C01295CE2DC9934928B005DD258A6637F534CB3D89A944230043801A596B234B7E58509E88798029600BCF5B3BA114F5B3BA10C9E77BAF20FA4016FCDD13340118B929DD4FD54E60327C00BEB7002080AA850031400D002369400B10034400F30021400F20157D804AD400FE00034E000A6D001EB2004E5C00B9AE3AC3C300470029091ACADBFA048D656DFD126792187008635CD736B3231A51BA5EBDF42D4D299804F26B33C872E213C840022EC9C21FFB34EDE7C559C8964B43F8AD77570200FC66697AFEB6C757AC0179AB641E6AD9022006065CEA714A4D24C0179F8E795D3078026200FC118EB1B40010A8D11EA27100990200C45A83F12C401A8611D60A0803B1723542889537EFB24D6E0844004248B1980292D608D00423F49F9908049798B4452C0131006230C14868200FC668B50650043196A7F95569CF6B663341535DCFE919C464400A96DCE1C6B96D5EEFE60096006A400087C1E8610A4401887D1863AC99F9802DC00D34B5BCD72D6F36CB6E7D95EBC600013A88010A8271B6281803B12E124633006A2AC3A8AC600BCD07C9851008712DEAE83A802929DC51EE5EF5AE61BCD0648028596129C3B98129E5A9A329ADD62CCE0164DDF2F9343135CCE2137094A620E53FACF37299F0007392A0B2A7F0BA5F61B3349F3DFAEDE8C01797BD3F8BC48740140004322246A8A2200CC678651AA46F09AEB80191940029A9A9546E79764F7C9D608EA0174B63F815922999A84CE7F95C954D7FD9E0890047D2DC13B0042488259F4C0159922B0046565833828A00ACCD63D189D4983E800AFC955F211C700";
        String test = "8A004A801A8002F478";
        String test2 = "A0016C880162017C3686B18A3D4780";
        Day16 d = new Day16();
        String binary = d.hexToBin(input);
        try{
        d.solution(binary, binary.length(), 5);}catch (Exception e){
            System.out.println("Solution: " + d.versions.stream().mapToInt(Integer::intValue).sum());
            e.printStackTrace();
        }
    }

    private void solution(String binary, int length, int j) {
        int v = Integer.parseInt(binary.substring(0, 3), 2);
        int t = Integer.parseInt(binary.substring(3, 6), 2);
        if (t != 4) {
            versions.add(v);
            int i = Integer.parseInt(binary.substring(6, 7), 2);
            int x = i == 0 ? 15 : 11;
            int l = Integer.parseInt(binary.substring(8, 7 + x), 2);
            String packages = binary.substring(7 + x);
            solution(packages, l, i);
        } else {
            if (j == 0) {
                decodePacket(binary, length);
            } else if (j == 1) {
                decodePacket1(binary, length);
            } else {
                decodePacket3(binary);
            }
        }
    }

    private void decodePacket1(String input, int length) {
        int current = 0;
        while (current < length) {
            int v = Integer.parseInt(input.substring(0, 3), 2);
            int t = Integer.parseInt(input.substring(3, 6), 2);
            versions.add(v);
            input = input.substring(6);
            String number = "";
            for (int i = 0; i + 5 < input.length(); i += 5) {
                String part = input.substring(i, i + 5);
                number += part.substring(1);
                if (part.startsWith("0")) {
                    current++;
                    input = input.substring(i + 5);
//                    System.out.println(Long.parseLong(number, 2));
                    break;
                }
            }
        }
        if (input.contains("1")) {
            solution(input, length, 13);
        }
    }

    private void decodePacket(String input, int length) {
        int current = 0;
        while (current < length) {
            int v = Integer.parseInt(input.substring(0, 3), 2);
            int t = Integer.parseInt(input.substring(3, 6), 2);
            versions.add(v);
            input = input.substring(6);
            current += 6;
            String number = "";
            for (int i = 0; i + 5 < length; i += 5) {
                String part = input.substring(i, i + 5);
                number += part.substring(1);
                current += 5;
                if (part.startsWith("0")) {
                    input = input.substring(i + 5);
//                    System.out.println(Long.parseLong(number, 2));
                    break;
                }
            }
        }
        if (input.contains("1")) {
            solution(input, length, 144);
        }
    }


    private void decodePacket3(String input) {
        int v = Integer.parseInt(input.substring(0, 3), 2);
        int t = Integer.parseInt(input.substring(3, 6), 2);
        versions.add(v);
        input = input.substring(6);
        String number = "";
        for (int i = 0; i + 5 < input.length(); i += 5) {
            String part = input.substring(i, i + 5);
            number += part.substring(1);
            if (part.startsWith("0")) {
                input = input.substring(i + 5);
//                    System.out.println(Long.parseLong(number, 2));
                break;
            }
        }
        if (input.contains("1")) {
            solution(input, 500, 500);
        }
    }

    private String hexToBin(String hex) {
        hex = hex.replaceAll("0", "0000");
        hex = hex.replaceAll("1", "0001");
        hex = hex.replaceAll("2", "0010");
        hex = hex.replaceAll("3", "0011");
        hex = hex.replaceAll("4", "0100");
        hex = hex.replaceAll("5", "0101");
        hex = hex.replaceAll("6", "0110");
        hex = hex.replaceAll("7", "0111");
        hex = hex.replaceAll("8", "1000");
        hex = hex.replaceAll("9", "1001");
        hex = hex.replaceAll("A", "1010");
        hex = hex.replaceAll("B", "1011");
        hex = hex.replaceAll("C", "1100");
        hex = hex.replaceAll("D", "1101");
        hex = hex.replaceAll("E", "1110");
        hex = hex.replaceAll("F", "1111");
        return hex;
    }
}
