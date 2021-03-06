/*
 * Copyright  2019 - present. IAB Tech Lab
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.media.openrtb3;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

/** Created by shiva.b on 14/12/18. */
public class EventSpec {
  @NotNull private Integer type;
  private Collection<Integer> method;
  private Collection<Integer> api;
  private Collection<String> jstrk;
  private Integer wjs;
  private Collection<String> pxtrk;
  private Integer wpx;
  private Map<String, Object> ext;

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Collection<Integer> getMethod() {
    return method;
  }

  public void setMethod(Collection<Integer> method) {
    this.method = method;
  }

  public Collection<Integer> getApi() {
    return api;
  }

  public void setApi(Collection<Integer> api) {
    this.api = api;
  }

  public Collection<String> getJstrk() {
    return jstrk;
  }

  public void setJstrk(Collection<String> jstrk) {
    this.jstrk = jstrk;
  }

  public Integer getWjs() {
    return wjs;
  }

  public void setWjs(Integer wjs) {
    this.wjs = wjs;
  }

  public Collection<String> getPxtrk() {
    return pxtrk;
  }

  public void setPxtrk(Collection<String> pxtrk) {
    this.pxtrk = pxtrk;
  }

  public Integer getWpx() {
    return wpx;
  }

  public void setWpx(Integer wpx) {
    this.wpx = wpx;
  }

  public Map<String, Object> getExt() {
    return ext;
  }

  public void setExt(Map<String, Object> ext) {
    this.ext = ext;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EventSpec eventSpec = (EventSpec) o;
    return Objects.equals(getType(), eventSpec.getType())
        && Objects.equals(getMethod(), eventSpec.getMethod())
        && Objects.equals(getApi(), eventSpec.getApi())
        && Objects.equals(getJstrk(), eventSpec.getJstrk())
        && Objects.equals(getWjs(), eventSpec.getWjs())
        && Objects.equals(getPxtrk(), eventSpec.getPxtrk())
        && Objects.equals(getWpx(), eventSpec.getWpx())
        && Objects.equals(getExt(), eventSpec.getExt());
  }

  @Override
  public int hashCode() {

    return Objects.hash(
        getType(), getMethod(), getApi(), getJstrk(), getWjs(), getPxtrk(), getWpx(), getExt());
  }
}
