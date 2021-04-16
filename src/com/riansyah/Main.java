package com.riansyah;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.MissingResourceException;

import com.beust.jcommander.JCommander;
import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;
import it.unimib.disco.essere.dfmc4j.ast.parser.ASTParserManager;
import it.unimib.disco.essere.dfmc4j.jobcontroller.exceptions.ParserOrCompilerErrorException;
import it.unimib.disco.essere.dfmc4j.model.codeelement.interfaces.*;
import it.unimib.disco.essere.dfmc4j.model.codeelement.interfaces.Package;
import it.unimib.disco.essere.dfmc4j.model.codeinformation.interfaces.Metric;
import it.unimib.disco.essere.dfmc4j.model.handler.ModelHandler;
import it.unimib.disco.essere.jcodeodor.detection.Detector;
import it.unimib.disco.essere.jcodeodor.model.ModelDataHolder;
import it.unimib.disco.essere.jcodeodor.threshold.Thresholds;
import it.unimib.disco.essere.sandbox.MetricDetector;
import it.unimib.disco.essere.sandbox.Parameters;
import it.unimib.disco.essere.sandbox.model.Measure;
import it.unimib.disco.essere.sandbox.model.Type;
import it.unimib.disco.essere.sandbox.outputStrategy.OutputInterface;
import org.eclipse.jdt.core.compiler.IProblem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Parameters params = new Parameters();
    private static final Logger mLogger = LoggerFactory.getLogger(MetricDetector.class);
//addmetric nya bervarian
//    add metric untuk method
    private void addMetrics(Measurable pack, it.unimib.disco.essere.sandbox.model.Method p) {
        Metric[] var6;
        int var5 = (var6 = pack.getMetrics()).length;

        for(int var4 = 0; var4 < var5; ++var4) {
            Metric metric = var6[var4];
            p.addMetric(new Measure(metric.getName(), metric.getValue()));
        }

    }

    private Detector detectSmells(Project project) {
        Thresholds.initThresholds();
        ModelDataHolder.initModelDataHolderFromModel(project);
        Detector detect = new Detector();
        detect.setOnlyDetection(false);
        detect.setLoadModelElement(false);

        try {
            detect.detectSmell();
            return detect;
        } catch (Exception var4) {
            throw Throwables.propagate(var4);
        }
    }
    private it.unimib.disco.essere.sandbox.model.Project fillProject(Project project, Detector detector) {
        it.unimib.disco.essere.sandbox.model.Project mine = new it.unimib.disco.essere.sandbox.model.Project(project.getName());
//        Package[] var7;
//        int var6 = (var7 = project.getProjectPackages()).length;
//
//        for(int var5 = 0; var5 < var6; ++var5) {
//            Package pack = var7[var5];
//
//            it.unimib.disco.essere.sandbox.model.Package p = new it.unimib.disco.essere.sandbox.model.Package(pack.getQualifiedName());
//            this.addMetrics(pack, (it.unimib.disco.essere.sandbox.model.Package)p);
//
//            Iterable<ComplexType> types = Iterables.filter(Arrays.asList(pack.getPackageTypes()), ComplexType.class);
//            Iterator var11 = types.iterator();
//
//            while(var11.hasNext()) {
//                ComplexType type = (ComplexType)var11.next();
//                Type t = new Type(type.getName());
//                this.addMetrics(type, (Type) t);
//                Method[] var16;
//                int var15 = (var16 = type.getMethods()).length;
//
//                for(int var14 = 0; var14 < var15; ++var14) {
//                    Method method = var16[var14];
//                    it.unimib.disco.essere.sandbox.model.Method m = new it.unimib.disco.essere.sandbox.model.Method(method);
//                    this.addMetrics(method, (it.unimib.disco.essere.sandbox.model.Method) m);
//
//                    t.addMethod(m);
//                }
//
//                p.addType(t);
//            }
//
//            mine.addPackage(p);
//        }

        return mine;
    }
    void compute() throws IOException, ParserOrCompilerErrorException {
        try {
            mLogger.info("Starting analysis...");
            ASTParserManager parser = params.getInputType().createParserManager(params);
            HashMap<String, IProblem> errors = parser.getErrors();
//            didalam compute ini dipelajari lagi
//            bagian mana file.properties dibaca didalam kode ini ?
            if (errors.isEmpty()) {
//                ModelHandler model = new ModelHandler(parser, params.getAnalysis());
//                model.computeAll(1, params.getThreadsNumber());
//                Project project = model.getProject();
//                it.unimib.disco.essere.sandbox.model.Project mine = this.fillProject(project, this.detectSmells(project));
//                String outputFile = params.getOutput();
//                OutputInterface outputStrategy = params.getOutputType();
//                mLogger.info("Type of chosen output: {}", outputStrategy.outputType());
//
//                try {
//                    mLogger.info("Saving analysis model to element: {}", outputFile);
//                    outputStrategy.publish(outputFile, mine);
//                } catch (Exception var9) {
//                    var9.printStackTrace();
//                }
//
//                model.deleteModel(true);
//                ModelDataHolder.disposeModelDataHolder();
                mLogger.info("Analysis finished");
            } else {
                mLogger.error("There are some parsing errors:");
                Iterator var4 = errors.values().iterator();

                while(var4.hasNext()) {
                    IProblem entry = (IProblem)var4.next();
                    mLogger.error(entry.getMessage() + " - in file: " + String.copyValueOf(entry.getOriginatingFileName()) + " - at line: " + entry.getSourceLineNumber());
                }

                mLogger.error("The analysis will be aborted");
                throw new ParserOrCompilerErrorException("There are some parsing errors");
            }
        }catch (MissingResourceException var3){
            System.out.println("Can't find configuration file "+ params.getConfig().toString() );
        } catch (IOException e){
            System.out.println("get input type");
        }
    }
    public static void main(String[] args) {
        try {
//            Main main = new Main();
//            main.compute();
//            java -jar JCodeOdor-Launcher-1.0-standalone.jar -source omegat\src -lib omegat\.gradle ..\.jdks\.openjdk-15.0.2.intellij\ -output eks2.sqlite -JV 1.8
            System.out.println("Start !! ");

/*

        jadi dimana kah setconfig terjadi ?
        dimana terjadi args digunakan ?
        args belum pernah di assign
 */
        }catch (MissingResourceException var3){
            System.out.println("Can't find configuration file "+ params.getConfig().toString() );
        }
//        catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParserOrCompilerErrorException e) {
//            e.printStackTrace();
//        }
    }
}
