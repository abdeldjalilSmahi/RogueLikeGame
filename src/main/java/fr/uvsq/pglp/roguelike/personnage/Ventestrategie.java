package fr.uvsq.pglp.roguelike.personnage;

import fr.uvsq.pglp.roguelike.equipement.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ventestrategie implements Strategy {
    private List<ArmeContact> armeContacts;
    private List<ArmeDistance> armeDistances;
    private List<Armure> armures;
    private Personnage pj;
    public Ventestrategie() {
        this.armeContacts =
                Arrays.asList(ArmeContactType.values()).stream()
                        .map(e -> new ArmeContact(e))
                        .collect(Collectors.toList());
        this.armeDistances =
                Arrays.asList(ArmeDistanceType.values()).stream()
                        .map(e -> new ArmeDistance(e))
                        .collect(Collectors.toList());
        this.armures =
                Arrays.asList(ArmureType.values()).stream()
                        .map(e -> new Armure(e))
                        .collect(Collectors.toList());
    }

    public Personnage getPj() {
        return pj;
    }

    public void setPj(Personnage pj) {
        this.pj = pj;
    }

    @Override
    public void execute() {}

}
