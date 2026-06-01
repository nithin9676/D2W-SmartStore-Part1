package com.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.DTO.UploadSummaryDTO;
import com.Entity.VehicleGeneration;
import com.Entity.VehicleMake;
import com.Entity.VehicleModel;
import com.Entity.VehicleVariant;
import com.Repostory.VehicleGenerationRepository;
import com.Repostory.VehicleMakeRepository;
import com.Repostory.VehicleModelRepository;
import com.Repostory.VehicleVariantRepository;

@Service
public class BulkUploadService {

    @Autowired
    private VehicleMakeRepository makeRepository;

    @Autowired
    private VehicleModelRepository modelRepository;

    @Autowired
    private VehicleGenerationRepository generationRepository;

    @Autowired
    private VehicleVariantRepository variantRepository;

    public UploadSummaryDTO uploadVehicleVariants(
            MultipartFile file) {

        UploadSummaryDTO summary =
                new UploadSummaryDTO();

        int totalRows = 0;
        int savedRows = 0;
        int skippedRows = 0;

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    file.getInputStream()));

            String line;

            /*
             * Skip Header
             */
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                totalRows++;

                try {

                    String[] data =
                            line.split(",");

                    if (data.length < 14) {

                        skippedRows++;

                        continue;
                    }

                    /*
                     * CSV Columns
                     */

                    String makeName =
                            data[0].trim();

                    String modelName =
                            data[1].trim();

                    String generationName =
                            data[2].trim();

                    Integer generationStartYear =
                            Integer.parseInt(
                                    data[3].trim());

                    Integer generationEndYear =
                            Integer.parseInt(
                                    data[4].trim());

                    String variantName =
                            data[5].trim();

                    String fullName =
                            data[6].trim();

                    Integer variantStartYear =
                            Integer.parseInt(
                                    data[7].trim());

                    Integer variantEndYear =
                            Integer.parseInt(
                                    data[8].trim());

                    String engineCode =
                            data[9].trim();

                    String fuelType =
                            data[10].trim();

                    String transmission =
                            data[11].trim();

                    String chassisCode =
                            data[12].trim();

                    String region =
                            data[13].trim();

                    /*
                     * ==========================
                     * VEHICLE MAKE
                     * ==========================
                     */

                    VehicleMake make =
                            makeRepository
                                    .findByMakeNameIgnoreCase(
                                            makeName)
                                    .orElse(null);

                    if (make == null) {

                        make =
                                new VehicleMake();

                        make.setMakeName(
                                makeName);

                        make.setSlug(
                                makeName
                                        .toLowerCase()
                                        .replace(" ", "-"));

                        make.setIsActive(
                                true);

                        make =
                                makeRepository
                                        .save(make);
                    }

                    /*
                     * ==========================
                     * VEHICLE MODEL
                     * ==========================
                     */

                    VehicleModel model =
                            modelRepository
                                    .findByModelNameAndVehicleMake_Id(
                                            modelName,
                                            make.getId())
                                    .orElse(null);

                    if (model == null) {

                        model =
                                new VehicleModel();

                        model.setModelName(
                                modelName);

                        model.setSlug(
                                modelName
                                        .toLowerCase()
                                        .replace(" ", "-"));

                        model.setVehicleMake(
                                make);

                        model.setIsActive(
                                true);

                        model =
                                modelRepository
                                        .save(model);
                    }

                    /*
                     * ==========================
                     * VEHICLE GENERATION
                     * ==========================
                     */

                    VehicleGeneration generation =
                            generationRepository
                                    .findByGenerationNameAndVehicleModel_Id(
                                            generationName,
                                            model.getId())
                                    .orElse(null);

                    if (generation == null) {

                        generation =
                                new VehicleGeneration();

                        generation.setGenerationName(
                                generationName);

                        generation.setSlug(
                                generationName
                                        .toLowerCase()
                                        .replace(" ", "-"));

                        generation.setStartYear(
                                generationStartYear);

                        generation.setEndYear(
                                generationEndYear);

                        generation.setVehicleModel(
                                model);

                        generation.setIsActive(
                                true);

                        generation =
                                generationRepository
                                        .save(generation);
                    }

                    /*
                     * ==========================
                     * VEHICLE VARIANT
                     * ==========================
                     */

                    Optional<VehicleVariant>
                            existingVariant =
                            variantRepository
                                    .findByFullName(
                                            fullName);

                    if (existingVariant.isPresent()) {

                        skippedRows++;

                        continue;
                    }

                    VehicleVariant variant =
                            new VehicleVariant();

                    variant.setVariantName(
                            variantName);

                    variant.setFullName(
                            fullName);

                    variant.setSlug(
                            fullName
                                    .toLowerCase()
                                    .replace(" ", "-"));

                    variant.setStartYear(
                            variantStartYear);

                    variant.setEndYear(
                            variantEndYear);

                    variant.setEngineCode(
                            engineCode);

                    variant.setFuelType(
                            fuelType);

                    variant.setTransmission(
                            transmission);

                    variant.setChassisCode(
                            chassisCode);

                    variant.setRegion(
                            region);

                    variant.setVehicleGeneration(
                            generation);

                    variant.setIsActive(
                            true);

                    variantRepository
                            .save(variant);

                    savedRows++;

                } catch (Exception e) {

                    e.printStackTrace();

                    skippedRows++;
                }
            }

            summary.setTotalRows(
                    totalRows);

            summary.setSavedRows(
                    savedRows);

            summary.setSkippedRows(
                    skippedRows);

            summary.setMessage(
                    "Vehicle CSV Uploaded Successfully");

        } catch (Exception e) {

            e.printStackTrace();

            summary.setMessage(
                    "CSV Upload Failed");
        }

        return summary;
    }
}