package pl.wasat.smarthma.model.om;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class ProcessingInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    private String _prefix;
    private Method method;
    private ProcessorName processorName;
    private ProcessorVersion processorVersion;
    private ProcessingCenter processingCenter;
    private ProcessingDate processingDate;
    private ProcessingMode processingMode;
    private GroundTrackUncertainty groundTrackUncertainty;
    private List<SamplingRate> samplingRate = new ArrayList<SamplingRate>();
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String get_prefix() {
        return _prefix;
    }

    public void set_prefix(String _prefix) {
        this._prefix = _prefix;
    }

    public ProcessingInformation with_prefix(String _prefix) {
        this._prefix = _prefix;
        return this;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public ProcessingInformation withMethod(Method method) {
        this.method = method;
        return this;
    }

    public ProcessorName getProcessorName() {
        return processorName;
    }

    public void setProcessorName(ProcessorName processorName) {
        this.processorName = processorName;
    }

    public ProcessingInformation withProcessorName(ProcessorName processorName) {
        this.processorName = processorName;
        return this;
    }

    public ProcessorVersion getProcessorVersion() {
        return processorVersion;
    }

    public void setProcessorVersion(ProcessorVersion processorVersion) {
        this.processorVersion = processorVersion;
    }

    public ProcessingInformation withProcessorVersion(
            ProcessorVersion processorVersion) {
        this.processorVersion = processorVersion;
        return this;
    }

    public ProcessingCenter getProcessingCenter() {
        return processingCenter;
    }

    public void setProcessingCenter(ProcessingCenter processingCenter) {
        this.processingCenter = processingCenter;
    }

    public ProcessingInformation withProcessingCenter(
            ProcessingCenter processingCenter) {
        this.processingCenter = processingCenter;
        return this;
    }

    public ProcessingDate getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(ProcessingDate processingDate) {
        this.processingDate = processingDate;
    }

    public ProcessingInformation withProcessingDate(
            ProcessingDate processingDate) {
        this.processingDate = processingDate;
        return this;
    }

    public ProcessingMode getProcessingMode() {
        return processingMode;
    }

    public void setProcessingMode(ProcessingMode processingMode) {
        this.processingMode = processingMode;
    }

    public ProcessingInformation withProcessingMode(
            ProcessingMode processingMode) {
        this.processingMode = processingMode;
        return this;
    }

    public GroundTrackUncertainty getGroundTrackUncertainty() {
        return groundTrackUncertainty;
    }

    public void setGroundTrackUncertainty(
            GroundTrackUncertainty groundTrackUncertainty) {
        this.groundTrackUncertainty = groundTrackUncertainty;
    }

    public ProcessingInformation withGroundTrackUncertainty(
            GroundTrackUncertainty groundTrackUncertainty) {
        this.groundTrackUncertainty = groundTrackUncertainty;
        return this;
    }

    public List<SamplingRate> getSamplingRate() {
        return samplingRate;
    }

    public void setSamplingRate(List<SamplingRate> samplingRate) {
        this.samplingRate = samplingRate;
    }

    public ProcessingInformation withSamplingRate(
            List<SamplingRate> samplingRate) {
        this.samplingRate = samplingRate;
        return this;
    }

    @Override
    public String toString() {
        ToStringStyle style = new SmartHMAStringStyle();
        ToStringBuilder.setDefaultStyle(style);
        return ToStringBuilder.reflectionToString(this, style);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
