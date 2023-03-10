package agh.ics.oop;

import agh.ics.oop.genotype.*;
import agh.ics.oop.map.AbstractEvolutionMap;

public class EngineCreator {
    public static SimulationEngine createEngine(SimulationParameters simParams, AbstractEvolutionMap map){
        IMutationHandler mutationHandler = switch(simParams.getMutationHandlerType()){
            case RANDOM -> new RandomMutationHandler();
            case CORRECTION -> new CorrectionMutationHandler();
        };

        INextActGeneGenerator nextActGeneGenerator = switch(simParams.getNextActGeneGeneratorType()){
            case CRAZY -> new CrazyNextActGeneGenerator();
            case STABLE -> new StableActGeneGenerator();
        };

        return new SimulationEngine(map, simParams, mutationHandler, nextActGeneGenerator);
    }
}
