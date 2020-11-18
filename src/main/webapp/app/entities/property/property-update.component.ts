import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IProperty, Property } from 'app/shared/model/property.model';
import { PropertyService } from './property.service';

@Component({
  selector: 'jhi-property-update',
  templateUrl: './property-update.component.html',
})
export class PropertyUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    totalArea: [],
    description: [],
    status: [],
  });

  constructor(protected propertyService: PropertyService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ property }) => {
      this.updateForm(property);
    });
  }

  updateForm(property: IProperty): void {
    this.editForm.patchValue({
      id: property.id,
      totalArea: property.totalArea,
      description: property.description,
      status: property.status,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const property = this.createFromForm();
    if (property.id !== undefined) {
      this.subscribeToSaveResponse(this.propertyService.update(property));
    } else {
      this.subscribeToSaveResponse(this.propertyService.create(property));
    }
  }

  private createFromForm(): IProperty {
    return {
      ...new Property(),
      id: this.editForm.get(['id'])!.value,
      totalArea: this.editForm.get(['totalArea'])!.value,
      description: this.editForm.get(['description'])!.value,
      status: this.editForm.get(['status'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IProperty>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
