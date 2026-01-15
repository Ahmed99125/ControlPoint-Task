import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject, forkJoin, map, switchMap, tap } from 'rxjs';
import { Asset, SensorReading } from '../models/asset';

@Injectable({
  providedIn: 'root'
})

export class AssetService {
  private apiUrl = 'http://localhost:8080/api/assets';

  private assetsSubject = new BehaviorSubject<Asset[]>([]);
  
  public assets$ = this.assetsSubject.asObservable();

  constructor(private http: HttpClient) {
    this.startPolling();
  }

  private startPolling() {
    this.refreshData();

    setInterval(() => {
      this.refreshData();
    }, 5000);
  }

  private refreshData() {
    this.http.get<Asset[]>(this.apiUrl).pipe(
      switchMap(assets => {
        const readingRequests = assets.map(asset => 
          this.http.get<SensorReading>(`${this.apiUrl}/${asset.id}/readings/latest`).pipe(
            map(reading => ({ ...asset, lastReading: reading })) 
          )
        );
        return forkJoin(readingRequests);
      })
    ).subscribe({
      next: (fullData) => {
        this.assetsSubject.next(fullData); 
      },
      error: (err) => console.error('Global Fetch Error:', err)
    });
  }

  getAssetById(id: number): Observable<Asset | undefined> {
    return this.assets$.pipe(
      map(assets => assets.find(a => a.id === id))
    );
  }
}