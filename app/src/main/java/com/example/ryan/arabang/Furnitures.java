package com.example.ryan.arabang;

import java.util.ArrayList;
import java.util.Arrays;


public class Furnitures { // int[style][index]
    static String[] BATH_LINKS = {
            "minimal bathroom furniture", "classic bathroom furniture", "elegance bathroom furniture", "modern bathroom furniture", "hightech bathroom furniture", "romantic bathroom furniture"
    };
    static String[] BED_LINKS = {
            "minimal bed", "classic bed", "elegance bed ", "modern bed ", "hightech bed ", "romantic bed "
    };
    static String[] KITCHEN_LINKS = {
            "minimal style kitchen", "classic style kitchen", "elegance style kitchen", "modern style kitchen", "hightech style kitchen", "romantic style kitchen"
    };
    static String[] OFFICE_LINKS = {
            "minimal office furniture", "classic office furniture", "elegance office furniture", "modern office furniture", "hightech office furniture", "romantic office furniture"
    };
    static String[] ROOM_LINKS = {
            "minimal room furniture", "classic room furniture", "elegance room furniture", "modern room furniture", "hightech room furniture", "romantic room furniture"
    };


    static ArrayList<String> names = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
    static ArrayList minimal_bath = new ArrayList<>(Arrays.asList(R.mipmap.minimal_bath1, R.mipmap.minimal_bath2, R.mipmap.minimal_bath3, R.mipmap.minimal_bath4, R.mipmap.minimal_bath5));
    static ArrayList classic_bath = new ArrayList<>(Arrays.asList(R.mipmap.classic_bath1, R.mipmap.classic_bath2, R.mipmap.classic_bath3, R.mipmap.classic_bath4, R.mipmap.classic_bath5));
    static ArrayList elegance_bath = new ArrayList<>(Arrays.asList(R.mipmap.elegance_bath1, R.mipmap.elegance_bath2, R.mipmap.elegance_bath3, R.mipmap.elegance_bath4, R.mipmap.elegance_bath5));
    static ArrayList modern_bath = new ArrayList<>(Arrays.asList(R.mipmap.modern_bath1, R.mipmap.modern_bath2, R.mipmap.modern_bath3, R.mipmap.modern_bath4, R.mipmap.modern_bath5));
    static ArrayList hightech_bath = new ArrayList<>(Arrays.asList(R.mipmap.hightech_bath1, R.mipmap.hightech_bath2, R.mipmap.hightech_bath3, R.mipmap.hightech_bath4, R.mipmap.hightech_bath5));
    static ArrayList romantic_bath = new ArrayList<>(Arrays.asList(R.mipmap.romantic_bath1, R.mipmap.romantic_bath2, R.mipmap.romantic_bath3, R.mipmap.romantic_bath4, R.mipmap.romantic_bath5));
    static ArrayList[] BATH_MIPMAPS = new ArrayList[]{minimal_bath, classic_bath, elegance_bath, modern_bath, hightech_bath, romantic_bath};

    static ArrayList minimal_bed = new ArrayList<>(Arrays.asList(R.mipmap.minimal_bed1, R.mipmap.minimal_bed2, R.mipmap.minimal_bed3, R.mipmap.minimal_bed4, R.mipmap.minimal_bed5));
    static ArrayList classic_bed = new ArrayList<>(Arrays.asList(R.mipmap.classic_bed1, R.mipmap.classic_bed2, R.mipmap.classic_bed3, R.mipmap.classic_bed4, R.mipmap.classic_bed5));
    static ArrayList elegance_bed = new ArrayList<>(Arrays.asList(R.mipmap.elegance_bed1, R.mipmap.elegance_bed2, R.mipmap.elegance_bed3, R.mipmap.elegance_bed4, R.mipmap.elegance_bed5));
    static ArrayList modern_bed = new ArrayList<>(Arrays.asList(R.mipmap.modern_bed1, R.mipmap.modern_bed2, R.mipmap.modern_bed3, R.mipmap.modern_bed4, R.mipmap.modern_bed5));
    static ArrayList hightech_bed = new ArrayList<>(Arrays.asList(R.mipmap.hightech_bed1, R.mipmap.hightech_bed2, R.mipmap.hightech_bed3, R.mipmap.hightech_bed4, R.mipmap.hightech_bed5));
    static ArrayList romantic_bed = new ArrayList<>(Arrays.asList(R.mipmap.romantic_bed1, R.mipmap.romantic_bed2, R.mipmap.romantic_bed3, R.mipmap.romantic_bed4, R.mipmap.romantic_bed5));
    static ArrayList[] BED_MIPMAPS = new ArrayList[]{minimal_bed, classic_bed, elegance_bed, modern_bed, hightech_bed, romantic_bed};

    static ArrayList minimal_kitchen = new ArrayList<>(Arrays.asList(R.mipmap.minimal_kitchen1, R.mipmap.minimal_kitchen2, R.mipmap.minimal_kitchen3, R.mipmap.minimal_kitchen4, R.mipmap.minimal_kitchen5));
    static ArrayList classic_kitchen = new ArrayList<>(Arrays.asList(R.mipmap.classic_kitchen1, R.mipmap.classic_kitchen2, R.mipmap.classic_kitchen3, R.mipmap.classic_kitchen4, R.mipmap.classic_kitchen5));
    static ArrayList elegance_kitchen = new ArrayList<>(Arrays.asList(R.mipmap.elegance_kitchen1, R.mipmap.elegance_kitchen2, R.mipmap.elegance_kitchen3, R.mipmap.elegance_kitchen4, R.mipmap.elegance_kitchen5));
    static ArrayList modern_kitchen = new ArrayList<>(Arrays.asList(R.mipmap.modern_kitchen1, R.mipmap.modern_kitchen2, R.mipmap.modern_kitchen3, R.mipmap.modern_kitchen4, R.mipmap.modern_kitchen5));
    static ArrayList hightech_kitchen = new ArrayList<>(Arrays.asList(R.mipmap.hightech_kitchen1, R.mipmap.hightech_kitchen2, R.mipmap.hightech_kitchen3, R.mipmap.hightech_kitchen4, R.mipmap.hightech_kitchen5));
    static ArrayList romantic_kitchen = new ArrayList<>(Arrays.asList(R.mipmap.romantic_kitchen1, R.mipmap.romantic_kitchen2, R.mipmap.romantic_kitchen3, R.mipmap.romantic_kitchen4, R.mipmap.romantic_kitchen5));
    static ArrayList[] KITCHEN_MIPMAPS = new ArrayList[]{minimal_kitchen, classic_kitchen, elegance_kitchen, modern_kitchen, hightech_kitchen, romantic_kitchen};

    static ArrayList minimal_office = new ArrayList<>(Arrays.asList(R.mipmap.minimal_office1, R.mipmap.minimal_office2, R.mipmap.minimal_office3, R.mipmap.minimal_office4, R.mipmap.minimal_office5));
    static ArrayList classic_office = new ArrayList<>(Arrays.asList(R.mipmap.classic_office1, R.mipmap.classic_office2, R.mipmap.classic_office3, R.mipmap.classic_office4, R.mipmap.classic_office5));
    static ArrayList elegance_office = new ArrayList<>(Arrays.asList(R.mipmap.elegance_office1, R.mipmap.elegance_office2, R.mipmap.elegance_office3, R.mipmap.elegance_office4, R.mipmap.elegance_office5));
    static ArrayList modern_office = new ArrayList<>(Arrays.asList(R.mipmap.modern_office1, R.mipmap.modern_office2, R.mipmap.modern_office3, R.mipmap.modern_office4, R.mipmap.modern_office5));
    static ArrayList hightech_office = new ArrayList<>(Arrays.asList(R.mipmap.hightech_office1, R.mipmap.hightech_office2, R.mipmap.hightech_office3, R.mipmap.hightech_office4, R.mipmap.hightech_office5));
    static ArrayList romantic_office = new ArrayList<>(Arrays.asList(R.mipmap.romantic_office1, R.mipmap.romantic_office2, R.mipmap.romantic_office3, R.mipmap.romantic_office4, R.mipmap.romantic_office5));
    static ArrayList[] OFFICE_MIPMAPS = new ArrayList[]{minimal_office, classic_office, elegance_office, modern_office, hightech_office, romantic_office};

    static ArrayList minimal_room = new ArrayList<>(Arrays.asList(R.mipmap.minimal_room1, R.mipmap.minimal_room2, R.mipmap.minimal_room3, R.mipmap.minimal_room4, R.mipmap.minimal_room5));
    static ArrayList classic_room = new ArrayList<>(Arrays.asList(R.mipmap.classic_room1, R.mipmap.classic_room2, R.mipmap.classic_room3, R.mipmap.classic_room4, R.mipmap.classic_room5));
    static ArrayList elegance_room = new ArrayList<>(Arrays.asList(R.mipmap.elegance_room1, R.mipmap.elegance_room2, R.mipmap.elegance_room3, R.mipmap.elegance_room4, R.mipmap.elegance_room5));
    static ArrayList modern_room = new ArrayList<>(Arrays.asList(R.mipmap.modern_room1, R.mipmap.modern_room2, R.mipmap.modern_room3, R.mipmap.modern_room4, R.mipmap.modern_room5));
    static ArrayList hightech_room = new ArrayList<>(Arrays.asList(R.mipmap.hightech_room1, R.mipmap.hightech_room2, R.mipmap.hightech_room3, R.mipmap.hightech_room4, R.mipmap.hightech_room5));
    static ArrayList romantic_room = new ArrayList<>(Arrays.asList(R.mipmap.romantic_room1, R.mipmap.romantic_room2, R.mipmap.romantic_room3, R.mipmap.romantic_room4, R.mipmap.romantic_room5));
    static ArrayList[] ROOM_MIPMAPS = new ArrayList[]{minimal_room, classic_room, elegance_room, modern_room, hightech_room, romantic_room};

}