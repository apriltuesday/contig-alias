/*
 * Copyright 2020 EMBL - European Bioinformatics Institute
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.ebi.eva.contigalias.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class SequenceEntity {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @ApiModelProperty(value = "Autogenerated Primary Key.")
    private long id;

    @ApiModelProperty(value = "GenBank's name of the sequence.")
    private String genbankSequenceName;

    @ApiModelProperty(value = "ENA's name of the sequence")
    private String enaSequenceName;

    @ApiModelProperty(value = "Sequence's GenBank accession.")
    private String genbank;

    @ApiModelProperty(value = "Sequence's RefSeq accession.")
    private String refseq;

    @ApiModelProperty(value = "Sequence's UCSC style name")
    private String ucscName;

    @ApiModelProperty(value = "Sequence's MD5 checksum value.")
    private String md5checksum;

    @ApiModelProperty(value = "Sequence's TRUNC512 checksum value.")
    private String trunc512checksum;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(value = "Assembly that this sequence belongs to.")
    @ManyToOne(cascade = CascadeType.ALL)
    private AssemblyEntity assembly;

    public long getId() {
        return id;
    }

    public String getGenbankSequenceName() {
        return genbankSequenceName;
    }

    public SequenceEntity setGenbankSequenceName(String name) {
        this.genbankSequenceName = name;
        return this;
    }

    public String getEnaSequenceName() {
        return enaSequenceName;
    }

    public SequenceEntity setEnaSequenceName(String enaSequenceName) {
        this.enaSequenceName = enaSequenceName;
        return this;
    }


    public String getGenbank() {
        return genbank;
    }

    public SequenceEntity setGenbank(String genbank) {
        this.genbank = genbank;
        return this;
    }

    public String getRefseq() {
        return refseq;
    }

    public SequenceEntity setRefseq(String refseq) {
        this.refseq = refseq;
        return this;
    }

    public String getUcscName() {
        return ucscName;
    }

    public SequenceEntity setUcscName(String ucscName) {
        this.ucscName = ucscName;
        return this;
    }

    public String getMd5checksum() {
        return md5checksum;
    }

    public SequenceEntity setMd5checksum(String md5checksum) {
        this.md5checksum = md5checksum;
        return this;
    }

    public String getTrunc512checksum() {
        return trunc512checksum;
    }

    public SequenceEntity setTrunc512checksum(String trunc512checksum) {
        this.trunc512checksum = trunc512checksum;
        return this;
    }

    public AssemblyEntity getAssembly() {
        return assembly;
    }

    public SequenceEntity setAssembly(AssemblyEntity assembly) {
        this.assembly = assembly;
        return this;
    }

}
